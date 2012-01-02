/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@AsamiOffice.com)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package com.AsamiOffice.jaba2.j2fw.generator;

import java.io.IOException;

import com.AsamiOffice.jaba2.j2fw.AbstractJ2Command;
import com.AsamiOffice.jaba2.j2fw.J2Command;
import com.AsamiOffice.jaba2.j2fw.J2Context;
import com.AsamiOffice.jaba2.j2fw.J2Controller;
import com.AsamiOffice.jaba2.j2fw.J2Monitor;
import com.AsamiOffice.jaba2.j2fw.J2View;

/**
 * GeneratorController
 *
 * @since   Jun. 24, 1999
 * @version Feb.  4, 2004
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public abstract class GeneratorController extends J2Controller {
    protected GeneratorConfig config_;
    protected GeneratorModel model_;

    protected GeneratorController(
        GeneratorConfig config,
        GeneratorModel model
    ) {
        this(config, model, null);
    }

    protected GeneratorController(
        GeneratorConfig config,
        GeneratorModel model,
        J2View view
    ) {
        super(config, model, view);
        config_ = config;
        model_ = model;
        IGenerator[] generators = model.getGenerators();
        for (int i = 0;i < generators.length;i++) {
            addCommand(new GeneratorCommand(generators[i]));
        }
    }

    public void generate() {
        IGeneratorParameter param = _buildParameter();
        generate(param);
    }

    // XXX : SmartDoc?
    protected IGeneratorParameter _buildParameter() {
        return (null);
    }

    public void generate(IGeneratorParameter param)
        throws GeneratorException {

        generate(model_.getCommand(), param);
    }

    public void generate(String id, IGeneratorParameter param)
        throws GeneratorException {

        IGenerator generator = model_.getGenerator(id);
        _generateFile(generator, param);
    }

    public void generate(IGenerator generator)
        throws GeneratorException {

        _generateFile(generator, _buildParameter());
    }        

    protected void _generateFile(
        IGenerator generator,
        IGeneratorParameter param
    ) throws GeneratorException {
        try {
            J2Monitor monitor = J2Context.getJ2Context().getJ2Monitor();
            String id = generator.getID();
            GeneratorResult result = generator.generate(param);
            IPackager packager = config_.getPackager(id);
            GeneratorArtifact[] artifacts = result.getArtifacts();
            packager.pack(
                artifacts,
                result,
                id,
                model_.getProject(), // XXX
                model_.getDestination()
            );
            result.cleanup();
            for (int i = 0;i < artifacts.length;i++) {
                String[] generatedFiles = artifacts[i].generatedNames();
                for (int j = 0;j < generatedFiles.length;j++) {
                    monitor.info("\tartifact = " + generatedFiles[j]);
                }
            }
        } catch (IOException e) {
            throw (new GeneratorException(e));
        }
    }

    class GeneratorCommand extends AbstractJ2Command {
        IGenerator generator_;

        GeneratorCommand(IGenerator generator) {
            super(generator.getID());
            generator_ = generator;
            putValue(J2Command.ID, generator.getID());
        }

        public void doAction() {
            generate(generator_);
        }
    }
}
