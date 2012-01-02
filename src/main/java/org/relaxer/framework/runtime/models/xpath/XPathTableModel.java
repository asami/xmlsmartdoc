package org.relaxer.framework.runtime.models.xpath;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.relaxer.framework.runtime.model.AbstractRTableModel;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.models.xpath.XPathTableModel.TableBuilder.MetaDataNode;

import com.AsamiOffice.text.UString;

/**
 * XPathTableModel
 * 
 * @since   Sec. 27, 2005
 * @version Oct. 14, 2005
 * @author ASAMI, Tomoharu (asami@relaxer.org)
 */
public class XPathTableModel extends AbstractRTableModel {
    private List columns_ = new ArrayList(); 
    private Object[] records_;
    private String naSumbol_ = null;

    public XPathTableModel(Object[] records, IRModelContext context) throws RModelException {
        super(context);
        records_ = records;
    }

    public void setNASymbol(String symbol) {
        naSumbol_  = symbol;
    }

    public void addColumn(String name, String path) {
        Column column = new Column();
        column.name = name;
        column.path = new Path(path);
        columns_.add(column);
    }

    protected void _open_table() throws RModelException {
        setHead_();
        setBody_();
//        for (int y = 0;y < records_.length;y++) {
//            addRecord_(records_[y], y);
//        }	
    }

    private void setHead_() throws RModelException {
        Object[] columns = columns_.toArray();
        String[] head = new String[columns.length];
        for (int x = 0;x < columns.length;x++) {
            Column column = (Column)columns[x];
            head[x] = column.name;
        }
        setHead(head);
    }

    private void setBody_() throws RModelException {
        TableBuilder builder = new TableBuilder();
        builder.build();
    }

    private void addRecord_(Object record, int y) throws RModelException {
        Object[] columns = columns_.toArray();
        for (int x = 0;x < columns.length;x++) {
            String path = (String)columns[x]; // XXX
            try {
                String value = getProperty_(record, path);
                setString(x, y, value);
            } catch (IllegalAccessException e) {
                throw new RModelException(e);
            } catch (InvocationTargetException e) {
                throw new RModelException(e);
            } catch (NoSuchMethodException e) {
                throw new RModelException(e);
            }
        }
    }

    private boolean isMultiplicty_(Object record, String name) throws SecurityException, NoSuchMethodException {
        Class klass = record.getClass();
        String methodName = "get" + UString.capitalize(name);
        Method method = klass.getMethod(methodName, new Class[0]);
        Class returnType = method.getReturnType();
        if (returnType.isArray()) {
            return true;
        } else if (Collection.class.isAssignableFrom(returnType)) {
            return true;
        }
        return false;
    }

    private String getProperty_(Object record, String name) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Object result = getPropertyChild_(record, name);
        if (result == null) {
            return naSumbol_;
        } else {
            return result.toString();
        }
    }

    private String[] getProperties_(Object record, String name) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Object[] properties = getPropertyChildren_(record, name);
        if (properties == null) {
            return null;
        } else {
            String[] result = new String[properties.length];
            for (int i = 0;i < properties.length;i++) {
                result[i] = properties[i].toString();
            }
            return result;
        }
    }

    private Object getPropertyChild_(Object record, String name) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Class klass = record.getClass();
        String methodName = "get" + UString.capitalize(name);
        Method method = klass.getMethod(methodName, new Class[0]);
        return method.invoke(record, new Object[0]);
    }

    private Object[] getPropertyChildren_(Object record, String name) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Class klass = record.getClass();
        String methodName = "get" + UString.capitalize(name);
        Method method = klass.getMethod(methodName, new Class[0]);
        Object[] properties = (Object[])method.invoke(record, new Object[0]);
        return properties;
    }

    static class Column {
        String name;
        Path path;
    }

    public static class Path {
        private List list_ = new ArrayList();

        public Path(String path) {
            list_.addAll(Arrays.asList(UString.getTokens(path, "/")));
        }

        public LinkedList getPathComponentLinkedList() {
            LinkedList result = new LinkedList();
            result.addAll(list_);
            return result;
        }
        
    }

    class TableBuilder {
        private int y_ = 0;
        private MetaDataNode root_;

        public TableBuilder() throws RModelException {
            buildMetaData_();
        }

        private void buildMetaData_() throws RModelException {
            MetaDataBuilder maker = new MetaDataBuilder();
            maker.build();
        }

        class MetaDataNode {
            int x = -1;
            String name;
            List children = new ArrayList();
        }

        class MetaDataBuilder {
            private int x_;
            private MetaDataNode current_;
            private LinkedList comps_;

            public void build() throws RModelException {
                root_ = new MetaDataNode();
                Object[] columns = columns_.toArray();
                for (x_ = 0;x_ < columns.length;x_++) {
                    current_ = root_;
                    Column column = (Column)columns[x_];
                    comps_ = column.path.getPathComponentLinkedList();
                    buildMetaData_();
                }
            }

            private void buildMetaData_() throws RModelException {
                for (;;) {
                    String comp = (String)comps_.removeFirst();
                    if (comps_.isEmpty()) {
                        MetaDataNode node = new MetaDataNode();
                        node.x = x_;
                        node.name = comp;
                        current_.children.add(node);
                        break;
                    } else {
                        MetaDataNode node = getChild_(current_, comp);
                        node.x = -1;
                        current_ = node;
                    }
                }
            }

            private MetaDataNode getChild_(MetaDataNode node, String comp) {
                Object[] children = node.children.toArray();
                for (int i = 0;i < children.length;i++) {
                    MetaDataNode child = (MetaDataNode)children[i];
                    if (comp.equals(child.name)) {
                        return child;
                    }
                }
                MetaDataNode child = new MetaDataNode();
                child.name = comp;
                node.children.add(child);
                return child;
            }
        }

        public void build() throws RModelException {
            for (int i = 0;i < records_.length;i++) {
                addRecord_(records_[i]);
            }
        }

        private void addRecord_(Object record) throws RModelException {
            RecordBuilder builder = new RecordBuilder(record);
            builder.build();
        }

        class RecordBuilder {
            private Object record_;
            private MetaDataNode current_;

            public RecordBuilder(Object record) {
                record_ = record;
                current_ = root_;
            }

            public void build() throws RModelException {
                buildColumn_(current_, record_);
                y_++;
            }
            
            private void buildColumn_(MetaDataNode node, Object object) throws RModelException {
                Object[] children = node.children.toArray();
                for (int i = 0;i < children.length;i++) {
                    MetaDataNode child = (MetaDataNode)children[i];
                    if (child.x != -1) {
                        buildLeafColumn_(child, object);
                    }
                }
                for (int i = 0;i < children.length;i++) {
                    MetaDataNode child = (MetaDataNode)children[i];
                    if (child.x == -1) {
                        buildContainerColumn_(child, object);
                    }
                }
            }

            private void buildLeafColumn_(MetaDataNode node, Object object) throws RModelException {
                try {
                    if (isMultiplicty_(object, node.name)) {
                        String[] properties = getProperties_(object, node.name);
                        if (properties.length == 0) {
                            return;
                        }
                        for (int i = 0;i < properties.length - 1;i++) {
                            setString(node.x, y_++, properties[i]);
                        }
                        setString(node.x, y_, properties[properties.length - 1]);
                    } else {
                        String property = getProperty_(object, node.name);
                        setString(node.x, y_, property);
                    }
                } catch (SecurityException e) {
                    throw new RModelException(e);
                } catch (IllegalArgumentException e) {
                    throw new RModelException(e);
                } catch (NoSuchMethodException e) {
                    throw new RModelException(e);
                } catch (IllegalAccessException e) {
                    throw new RModelException(e);
                } catch (InvocationTargetException e) {
                throw new RModelException(e);
                }
            }

            private void buildContainerColumn_(MetaDataNode node, Object object) throws RModelException {
                try {
                    if (isMultiplicty_(object, node.name)) {
                        Object[] children = getPropertyChildren_(object, node.name);
                        if (children.length > 0) {
                            for (int i = 0;i < children.length - 1;i++) {
                                buildColumn_(node, children[i]);
                                y_++;
                            }
                            buildColumn_(node, children[children.length - 1]);
                        }
                    } else {
                        Object child = getPropertyChild_(object, node.name);
                        buildColumn_(node, child);
                    }
                } catch (RModelException e) {
                    throw new RModelException(e);
                } catch (SecurityException e) {
                    throw new RModelException(e);
                } catch (IllegalArgumentException e) {
                    throw new RModelException(e);
                } catch (NoSuchMethodException e) {
                    throw new RModelException(e);
                } catch (IllegalAccessException e) {
                    throw new RModelException(e);
                } catch (InvocationTargetException e) {
                    throw new RModelException(e);
                }
            }
        }

        class RecordBuilder0 {
            private Object record_;
            private int x_ = 0;

            public RecordBuilder0(Object record) {
                record_ = record;
            }

            public void build() throws RModelException {
                Object[] columns = columns_.toArray();
                for (x_ = 0;x_ < columns.length;x_++) {
                    Column column = (Column)columns[x_];
                    buildColumn_(record_, column.path);
                }
                y_++;
            }

            private void buildColumn_(Object record, Path path) throws RModelException {
                LinkedList comps = path.getPathComponentLinkedList();
                buildColumn_(record, comps);
            }
            
            private void buildColumn_(Object record, LinkedList comps) throws RModelException {
                try {
                    String comp = (String)comps.getFirst();
                    comps.removeFirst();
                    if (comps.isEmpty()) {
                        if (isMultiplicty_(record, comp)) {
                            String[] properties = getProperties_(record, comp);
                            if (properties.length == 0) {
                                return;
                            }
                            for (int i = 0;i < properties.length - 1;i++) {
                                setString(x_, y_++, properties[i]);
                            }
                            setString(x_, y_, properties[properties.length - 1]);
                        } else {
                            String property = getProperty_(record, comp);
                            setString(x_, y_, property);
                        }
                        return;
                    } else {
                        if (isMultiplicty_(record, comp)) {
                            Object[] children = getPropertyChildren_(record, comp);
                            if (children.length > 0) {
                                for (int i = 0;i < children.length - 1;i++) {
                                    buildColumn_(children[i], new LinkedList(comps));
                                }
                                buildColumn_(children[children.length - 1], new LinkedList(comps));
                            }
                        } else {
                            Object child = getPropertyChild_(record, comp);
                            buildColumn_(child, comps);
                        }
                    }
                } catch (SecurityException e) {
                    throw new RModelException(e);
                } catch (IllegalArgumentException e) {
                    throw new RModelException(e);
                } catch (NoSuchMethodException e) {
                    throw new RModelException(e);
                } catch (IllegalAccessException e) {
                    throw new RModelException(e);
                } catch (InvocationTargetException e) {
                    throw new RModelException(e);
                }
            }
        }
    }
}
