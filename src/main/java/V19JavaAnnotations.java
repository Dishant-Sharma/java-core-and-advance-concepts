public class V19JavaAnnotations {

    /*
       What is an Annotation?
           - it is a kind of adding meta-data to the java code.
           - it's usage is optional.
           - we can add this meta-data info at runtime and can add certain logic in our code if wanted.
           - to read this meta-data info we have to use reflections.
           - Annotations can be applied at anywhere like Classes, Methods, Interfaces, Fields, parameters,etc.
           - Annotations are represented using @
           - Example:

            public interface Bird {
                public boolean fly();
            }

            public class Eagle implements Bird{

                @Override // optional
                public boolean fly() {
                    return true;
                }
            }

         Types of Annotations:
            1. Pre-defined (already present in java)
            2. Custom/ User-defined ( our own @{Our custom name})

            - Pre-defined Annotations
                Types:
                    a) Used on top of Annotations (called Meta-Annotations/ Annotations on top of an Annotation)
                        i)   @Target
                        ii)  @Retention
                        iii) @Documented
                        iv)  @Inherited
                        v)   @Repeatable (Java 8 feature)

                    b) Used on Java code like Classes, Methods, etc.
                        i)   @Deprecated
                        ii)  @Override
                        iii) @SuppressWarnings
                        iv)  @FunctionalInterface
                        v)   @SafeVarargs

             - Annotations used on Java code (type (b))
             1) @Deprecated
                - usage of Deprecated Class or Method or fields shows you compile time WARNING.
                - Deprecation means no further improvement is happening on this entity and use new
                  alternative or field instead.
                - can be used over Constructor, Field, local variable, Method, Package, parameter,
                  Type (class, interface, enum).


                    public class Mobile{
                        @Deprecated
                         public void dummyMethod(){
                            //some code
                        }
                     }

                     public class A{
                         public static void main(String[] args) {
                             Mobile mobileObj = new Mobile();
                             mobileObj.dummyMethod(); // here it will show deprecated method
                         }
                     }

                2) Override
                    - during compile time it will check that the method should be overridden.
                    - and throws compile time error, if it does not match with the parent method.
                    - can be used over Methods.

                      public interface Bird{
                          public boolean fly();
                      }
                      public class Eagle implements Bird{
                          @Override
                          public boolean fly1(){
                              return true;
                          }
                      }

                3) @SuppressWarnings
                    - it will tell compiler to ignore any compile time warning.
                    - use it safely, could lead to run time exception if any valid warning is ignored.
                    - can be used over Constructor, Field, local variable, Method, parameter,
                      Type (class, interface, enum).

                           public class Mobile{
                                @Deprecated
                                public void dummyMethod(){
                                    // some code
                                }
                            }

                            public class Main{
                                public static void main(String[] args) {
                                    Mobile mobileObj = new Mobile();
                                    mobileObj.getDummyMethod();  // gives a warning
                                }
                            }
                    - say we don't want these warnings
                      we can put @SuppressWarnings() at method level like
                        public class Main{
                            @SuppressWarnings("deprecation")
                            public static void main(String[] args) {
                                Mobile mobileObj = new Mobile();
                                mobileObj.getDummyMethod();
                            }
                        }

                       OR we can use over the class that will apply for all the methods
                            @SuppressWarnings("deprecation")
                            public class Main{
                                public static void main(String[] args) {
                                    Mobile mobileObj = new Mobile();
                                    mobileObj.getDummyMethod();
                                }
                            }

                       OR if we want to remove all the warnings we can pass 'all' in @SuppressWarnings() parameter
                           @SuppressWarnings("all")
                            public class Main{
                                public static void main(String[] args) {
                                    Mobile mobileObj = new Mobile();
                                    mobileObj.getDummyMethod();
                                }
                            }

                  4) @FunctionalInterface
                    - restrict interface to have only 1 abstract method.
                    - throws compilation error, if more than 1 abstract method found.
                    - can be used over Type (Class or interface or enum)
                    - Eg:
                            @FunctionalInterface
                            public interface Bird{
                                public boolean fly();
                                public boolean eat();
                            }
                  5) @SafeVarargs
                    - used to suppress " Heap pollution warning"
                    - used over methods and constructors which has Variable Arguments as parameter.
                    - method should be either static or final i.e. methods which can't be overridden.
                    - In Java 9 we can also use it on private methods too.



                    - Heap pollution
                        - we have two types of memory stack and heap. heap stores object
                        - Object of one type( say String) storing the reference
                          of another type object ( say Integer) is heap pollution
                          public class Log{
                            public static void printLogValues(List<Integer>... logNumberList){ // logNumberList is varargs
                                Object [] ojectList = logNumberList;
                                List<String> stringValList = new ArrayList<>();
                                stringValList.add("Hello");
                                ojectList[0] = stringValList;
                            }
                        }

                        here as per definition of varargs we can pass zero or any
                        number of parameter in this method and internally java will
                        convert this varargs parameter to an array

                        Now we have a list of Integers which will be converted to an array, and we can pass
                        so many lists of Integers which will be pointed by each element of the array individually

                        logNumbersList will be pointing to a reference in the heap ---------------->[ 0 , 1, 2 ,3 ]
                                                                                                      |
                                                                                                      |
                                                                                                      V
                                                                                                     list of integer
                        Now we have an objectList pointing to the same array (Object [] ojectList = logNumberList)
                        and we are adding an object list which is a stringValList but logNumberList was of type List<Integer>
                        but here that reference will be pointing to the stringValList now so this is heap pollution.

                        we might get a heap pollution warning here. we can avoid it by adding @SafeVarargs

                        @SafeVarargs
                        public class Log{
                            public static void printLogValues(List<Integer>... logNumberList){ // logNumberList is varargs
                                Object [] ojectList = logNumberList;
                                List<String> stringValList = new ArrayList<>();
                                stringValList.add("Hello");
                                ojectList[0] = stringValList;
                            }
                        }
                     - Annotations used over other Annotations i.e. Meta Annotations (type (a))
                        a) @Target
                            - how to check which java annotations can be used over what like for eg:
                              @Deprecated is used over Constructor, Field, local variable, etc but who
                              defines that which annotation can be used at what place
                            -  @Target will restrict where to use the annotation.

                            Example: if we see the implementation of @Override annotation it looks like

                            @Target(ElementType.METHOD)  // limits it to be used over methods
                            public @interface Override{  // this is how Override is actually defined in java
                            }

                            Similarly,  for @SafeVarargs
                             @Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
                             public @interface SafeVarargs {}


                            Possible ElementType:
                                TYPE,
                                FIELD,
                                METHOD,
                                PARAMETER,
                                CONSTRUCTOR,
                                LOCAL_VARIABLE,
                                ANNOTATION_TYPE, ( if you check the implementation of @Target @Target(ElementType.ANNOTATION_TYPE)

                                                    @Target(ElementType.ANNOTATION_TYPE)
                                                    public @interface Target {
                                                        ElementType[] value();
                                                    }
                                                    Here ElementType.ANNOTATION_TYPE means it can be applied over annotations,
                                                    similarly, it can be applied over other annotations to make them meta. say

                                                    @Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
                                                    public @interface Override{
                                                    }
                                                    Now we can apply Override over other annotations


                                PACKAGE,
                                TYPE_PARAMETER, (allows you to apply on generic types <T>)
                                TYPE_USE (Java 8 feature, allows you to use annotation at all places where
                                           Type you can declare (like List<@annotation>))

                         b) @Retention
                            - this meta-annotation tells how an annotation will be stored in Java. 3 types of Policies:

                               - RententionPolicy.SOURCE: annotations will be discarded by the compiler itself and
                                it will not be recorded in .class file.
                               - RententionPolicy.CLASS: annotations will be recorded in .class file but will ve ignored
                                by JVM at run time.
                               - RetentionPolicy.RUNTIME: annotations will be recorded in .class file + available during
                                run time. Usage of reflection can be done.

                         c) @Documented
                            - by default annotations are ignored when java documentation is generated.
                            - with this meta-annotation even Annotations will come in java docs.

                         d) @Inherited
                            - by default Annotations applied on parent class are not available to child classes.
                            - but it can be done using this meta-annotation.


                            let's create a custom annotation for which we need to use @interface to denote a new annotation is created

                                    @Inherited
                                    @Target(ElementType.TYPE)
                                    @Retention(RetentionPolicy.RUNTIME)
                                    public @interface MyCustomAnnotationWithInherited{
                                    }


                            using it over a parent class

                                   @MyCustomAnnotationWithInherited
                                   public class ParentClass{
                                   }

                                   public class ChildClass extends ParentClass{
                                   }

                                   public class Main{
                                        public static void main(String[] args) {
                                                System.out.println( new ChildClass.getClass().
                                                getAnnotation(MyCustomAnnotationWithInherited));

                                   }

                            e) Repeatable
                                - allow us to use same annotation more than once at same place. JAVA 8 feature
                                - say we have a custom annotation to understand a use case where we might need this scenario

                                            @Target(ElementType.TYPE)
                                            @Retention(RetentionPolicy.RUNTIME)
                                            public @interface Category{
                                                String name;
                                            }

                                            @Category(name = "Bird")
                                            @Category(name = "LivingThing") // not allowed
                                            public class Eagle {
                                                public void fly(){
                                                }
                                            }

                                  To implement above requirement we can use @Repeatable like

                                  First we need to create a container for the customised annotation
                                  we want to repeat

                                  @Repeatable(Categories.class)
                                  @interface Category{
                                    String name;
                                   }


                                   @Retention(RetentionPolicy.RUNTIME)
                                   @interface Categories {
                                        Category [] value();
                                        }

                                   @Category(name = "Bird")
                                   @Category(name = "LivingThing") // these all are stored as list of Category in the Categories class
                                   @Category(name = "Carnivore")
                                   public class Eagle {
                                         public void fly(){
                                         }
                                   }


                                   public class Main{
                                        public static void main(String[] args) {
                                                Category [] categoryAnnotationArray = new Eagle().getClass().
                                                            getAnnotationsByType(Category.class);
                                                for(Category annotation : categoryAnnotationArray){

                                                    System.out.println(annotation.name());
                                                }
                                        }
                                   }

                    - User defined or custom annotation
                        - we can create our own ANNOTATION using keyword " @interface"

                        - creating an annotation with empty body:
                                   public @interface MyCustomAnnotation{
                                   }

                                   @MyCustomAnnotation
                                   public class Eagle {
                                        public void fly(){
                                        }
                                   }
                        - creating an annotation with a method ( which is more of like a field )
                            - no parameter, no body.
                            - return type is restricted to Primitive, Class, String, annotations and array of these types.


                            public @interface MyCustomAnnotation{
                                String name(); // here method acts more like an annotation member
                            }

                            @MyCustomAnnotation(name = "testing")
                            public class Eagle {
                                   public void fly(){
                                   }
                            }

                       - creating an annotation with an element with default values
                            - default value can not be null
                            - Example:
                                public @interface MyCustomAnnotation{
                                    String name() default "hello";
                                }

                                @MyCustomAnnotation
                                public class Eagle {
                                       public void fly(){
                                       }
                                }



















     */
}
