package com.wang;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by ddp on 2018/1/24.
 */
public class ListSortUtil<T> {
    public void mySort(List<T> list, final String sortField, final String sortRule) {

        Collections.sort(list, new Comparator<T>() {

            public int compare(T o1, T o2) {
                // 通过反射获取方法名称，如getId
                String methodName = "get" + sortField.substring(0, 1).toUpperCase() + sortField.substring(1, sortField.length());
                String flag = null;
                try {
                    Field[] fields = o1.getClass().getDeclaredFields();
                    for (Field f : fields) {
                        if (sortField.equals(f.getName())) {
                            if (f.getGenericType().toString().equals("class java.util.Date")) {
                                flag = "Date";
                                break;
                            }
                            if (f.getGenericType().toString().equals("class java.lang.String")) {
                                flag = "String";
                                break;
                            }
                            if (f.getGenericType().toString().equals("int")) {
                                flag = "int";
                                break;
                            }
                            if (f.getGenericType().toString().equals("class java.lang.Integer")) {
                                flag = "Integer";
                                break;
                            }
                            if (f.getGenericType().toString().equals("double")) {
                                flag = "double";
                                break;
                            }
                            if (f.getGenericType().toString().equals("class java.lang.Double")) {
                                flag = "Double";
                                break;
                            }
                            if (f.getGenericType().toString().equals("float")) {
                                flag = "float";
                                break;
                            }
                            if (f.getGenericType().toString().equals("class java.lang.Float")) {
                                flag = "Float";
                                break;
                            }
                        }
                    }

                    Method method1 = o1.getClass().getMethod(methodName, null);
                    Method method2 = o2.getClass().getMethod(methodName, null);
                    if ("Date".equals(flag)) {
                        if ("desc".equals(sortRule)) {
                            if (method1.invoke(o1, null) == null || method2.invoke(o2, null) == null)
                                return 1;
                            else
                                return ((Date) method1.invoke(o1, null)).getTime() < ((Date) method2.invoke(o2, null)).getTime() ? 1 : -1;
                        } else {
                            if (method1.invoke(o1, null) == null || method2.invoke(o2, null) == null)
                                return 1;
                            else
                                return ((Date) method1.invoke(o1, null)).getTime() < ((Date) method2.invoke(o2, null)).getTime() ? -1 : 1;
                        }
                    } else if ("String".equals(flag)) {
                        if ("desc".equals(sortRule)) {
                            if (method1.invoke(o1, null) == null || method2.invoke(o2, null) == null)
                                return 1;
                            else
                                return method2.invoke(o2, null).toString().compareTo(method1.invoke(o1, null).toString());
                        } else {
                            if (method1.invoke(o1, null) == null || method2.invoke(o2, null) == null)
                                return 1;
                            else
                                return method1.invoke(o1, null).toString().compareTo(method2.invoke(o2, null).toString());
                        }
                    } else if ("int".equals(flag) || "Integer".equals(flag)) {
                        if ("desc".equals(sortRule)) {
                            if (method1.invoke(o1, null) == null || method2.invoke(o2, null) == null)
                                return 1;
                            else
                                return ((Integer) method2.invoke(o2, null)).compareTo((Integer) method1.invoke(o1, null));
                        } else {
                            if (method1.invoke(o1, null) == null || method2.invoke(o2, null) == null)
                                return 1;
                            else
                                return ((Integer) method1.invoke(o1, null)).compareTo((Integer) method2.invoke(o2, null));
                        }
                    } else if ("double".equals(flag) || "Double".equals(flag)) {
                        if ("desc".equals(sortRule)) {
                            if (method1.invoke(o1, null) == null || method2.invoke(o2, null) == null)
                                return 1;
                            else
                                return ((Double) method2.invoke(o2, null)).compareTo((Double) method1.invoke(o1, null));
                        } else {
                            if (method1.invoke(o1, null) == null || method2.invoke(o2, null) == null)
                                return 1;
                            else
                                return ((Double) method1.invoke(o1, null)).compareTo((Double) method2.invoke(o2, null));
                        }
                    } else if ("float".equals(flag) || "Float".equals(flag)) {
                        if ("desc".equals(sortRule)) {
                            if (method1.invoke(o1, null) == null || method2.invoke(o2, null) == null)
                                return 1;
                            else
                                return ((Float) method1.invoke(o1, null)) < ((Float) method2.invoke(o2, null)) ? 1 : -1;
                        } else {
                            if (method1.invoke(o1, null) == null || method2.invoke(o2, null) == null)
                                return 1;
                            else
                                return ((Float) method1.invoke(o1, null)) < ((Float) method2.invoke(o2, null)) ? -1 : 1;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }
}
