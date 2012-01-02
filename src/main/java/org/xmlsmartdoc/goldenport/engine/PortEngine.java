/*
 * org.xmlsmartdoc.goldenport
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.xmlsmartdoc.goldenport.engine;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xmlsmartdoc.goldenport.GoldenportContext;
import org.xmlsmartdoc.goldenport.adapter.IAdapter;
import org.xmlsmartdoc.goldenport.converter.IConverter;
import org.xmlsmartdoc.goldenport.filter.IFilter;
import org.xmlsmartdoc.goldenport.normalizer.INormalizer;
import org.xmlsmartdoc.goldenport.evaluater.Evaluater;

/**
 * PortEngine
 *
 * @since   Feb.  9, 2004
 * @version May. 11, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class PortEngine implements IPortConstants {
    private PortConfig config_;
    private GoldenportContext context_;

    public PortEngine(PortConfig config) {
        config_ = config;
    }

    public PortEngine(PortConfig config, GoldenportContext context) {
        config_ = config;
        context_ = context;
    }

    public GoldenportContext getContext() {
        return (context_);
    }

    public Document eval(Document doc, PortContext context) 
      throws GoldenportException {
        Element root = doc.getDocumentElement();
        Node result = eval(root, context);
        doc.removeChild(root);
        doc.appendChild(result);
        return (doc);
    }

    public Node eval(Element element, PortContext context) 
      throws GoldenportException {
        Node node = executeAdapters(element, context);
        if (!(node instanceof Element)) {
            return (node);
        }
        node = executeEvaluater_(
            config_.getMacros(),
            (Element)node,
            context
        );
        if (!(node instanceof Element)) {
            return (node);
        }
        node = executeFilters_(
            config_.getSystemFilters(),
            (Element)node,
            context
        );
        if (!(node instanceof Element)) {
            return (node);
        }
        node = executeFilters_(
            config_.getUserFilters(),
            (Element)node,
            context
        );
        if (!(node instanceof Element)) {
            return (node);
        }
        node = executeNormalizers_(
            config_.getSystemNormalizers(),
            (Element)node,
            context
        );
        if (!(node instanceof Element)) {
            return (node);
        }
        node = executeNormalizers_(
            config_.getUserNormalizers(),
            (Element)node,
            context
        );
        if (!(node instanceof Element)) {
            return (node);
        }
        node = executeConverters_(
            config_.getSystemConverters(),
            (Element)node,
            context
        );
        if (!(node instanceof Element)) {
            return (node);
        }
        node = executeConverters_(
            config_.getUserConverters(),
            (Element)node,
            context
        );
        return (node);
    }

    public Node executeAdapters(Element element, PortContext context)
        throws GoldenportException {
        Node node = executeAdapters_(
            config_.getSystemAdapters(),
            element,
            context
        );
        if (!(node instanceof Element)) {
            return (node);
        }
        node = executeAdapters_(
            config_.getUserAdapters(),
            (Element)node,
            context
        );
        return (node);
    }

    private Node executeFilters_(
        IFilter[] filters, 
        Element element, 
        PortContext context
    ) throws GoldenportException {
        return (executePorts_(filters, element, context));
    }

    private Node executeAdapters_(
        IAdapter[] adapters, 
        Element element, 
        PortContext context
    ) throws GoldenportException {
        return (executePorts_(adapters, element, context));
    }

    private Node executeNormalizers_(
        INormalizer[] normalizers, 
        Element element, 
        PortContext context
    ) throws GoldenportException {
        return (executePorts_(normalizers, element, context));
    }

    private Node executeEvaluater_(
        Node[] macros,
        Element element, 
        PortContext context
    ) throws GoldenportException {
        Evaluater evaluater = new Evaluater(macros);
        evaluater.setup(element);
        context.setPort(evaluater);
        return (_evalChild(element, context));
    }

    private Node executeConverters_(
        IConverter[] converters, 
        Element element, 
        PortContext context
    ) throws GoldenportException {
        return (executePorts_(converters, element, context));
    }

    private Node executePorts_(
        IPort[] ports, 
        Element element, 
        PortContext context
    ) throws GoldenportException {
        Node node = element;
        for (int i = 0;i < ports.length;i++) {
            context.setPort(ports[i]);
            node = _evalChild((Element)node, context);
            if (node == null) {
                return (null);
            }
        }
        return (node);
    }

    protected final PortNodeList _evalChildren(
        PortNodeList source,
        PortContext context
    ) throws GoldenportException {
        PortNodeList result = new PortNodeList(source.getFactoryDocument());
        result.setElement(source.getElement());
        int size = source.size();
        for (int i = 0; i < size; i++) {
            Node child = source.getChild(i);
            //System.out.println(child.toString());
            switch (child.getNodeType()) {

              case Node.ELEMENT_NODE :
                Node evaluated = _evalChild((Element)child, context);
                if (evaluated != null) {
                    result.addChild(evaluated);
                }
                break;
              default :
                result.addChild(child);
            }
        }
        return (result);
    }

    protected final Node _evalChild(Element child, PortContext context)
      throws GoldenportException {
        IPort port = context.getPort();
        if (!port.isAccept(child)) {
            Document doc = child.getOwnerDocument();
            PortNodeList result = new PortNodeList(doc);
            result.setElement(child);
            result.addChildren(child);
            result = _evalChildren(result, context);
            return (result.makeNode());
        } else {
            //System.out.println("evalChild = " + child.getLocalName());
            Document doc = child.getOwnerDocument();
            PortNodeList halfResult = new PortNodeList(doc);
            PortNodeList result = new PortNodeList(doc);
            int status = port.startElement(child, context, halfResult);
            switch (status) {
              case EVAL_DONE :
                return (halfResult.makeNode());
              case EVAL_CHILDREN :
                halfResult = _evalChildren(halfResult, context);
                port.endElement(child, halfResult, context, result);
                return (result.makeNode());
              default :
                throw (new InternalError());
            }
        }
    }
}
