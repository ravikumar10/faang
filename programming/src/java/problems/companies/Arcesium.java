package src.java.problems.companies;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Arcesium {
    public static void main(String[] args) {
        String x =  "${a} ${b} a 10";
        Pattern logEntry = Pattern.compile("\\{(.*?)\\}");
        Matcher matchPattern = logEntry.matcher(x);

        while(matchPattern.find()) {
            System.out.println(matchPattern.group(1));
        }

        String k = "${a}";

//        System.out.println(x.replaceAll("\\$\\{a\\}", "10"));
//        System.out.println(x.replaceAll("\\$\\{b\\}", "20"));

        evaluate(s).forEach(System.out::println);
    }

    public static List<String> evaluate(String api) {
        List<String> res = new ArrayList<>();
        Gson gson = new Gson();

        RootExp[] rootExp = gson.fromJson(api, RootExp[].class);
        for(RootExp r : rootExp)
                 res.add(r.processExpression());

        return res;

    }



        class RootExp {

            @SerializedName("groupName")
            @Expose
            private String groupName;
            @SerializedName("expressions")
            @Expose
            private List<Expression> expressions = null;

            public String getGroupName() {
                return groupName;
            }

            public void setGroupName(String groupName) {
                this.groupName = groupName;
            }

            public List<Expression> getExpressions() {
                return expressions;
            }

            public void setExpressions(List<Expression> expressions) {
                this.expressions = expressions;
            }

            public String processExpression(){
                List<String> res = new ArrayList<>();
                Map<String, String> exp = new HashMap<>();
                for(Expression e : expressions){
                    if(e.getExpressionType()!= null && e.getExpressionType().equals("DIRECT")){
                        String key = "${"+e.getName()+"}";
                        exp.put(key, e.getExpression());
                    }
                }

                for(Expression e : expressions){
                    if(e.getExpressionType()!= null && e.getExpressionType().equals("RS_EXPRESSION") && e.getExpression() != null){
                        String exVal = e.getExpression();
                        Pattern p = Pattern.compile("\\{(.*?)\\}");
                        Matcher matchPattern = p.matcher(e.getExpression());

                        while(matchPattern.find()) {
                            String k = "${"+matchPattern.group(1)+"}";
                            String val = exp.get(k);
                            String rep = "\\$\\{"+matchPattern.group(1)+"\\}";
                            exVal = exVal.replaceAll(rep, val);

                        }
                        String r = e.getName()+":"+exVal+" RS";
                        res.add(r);
                    } else if(e.getExpressionType()!= null && e.getExpressionType().equals("DOLLAR_EXPRESSION") && e.getExpression() != null){
                        String exVal = e.getExpression();
                        Pattern p = Pattern.compile("\\{(.*?)\\}");
                        Matcher matchPattern = p.matcher(e.getExpression());

                        while(matchPattern.find()) {
                            String k = "${"+matchPattern.group(1)+"}";
                            String val = exp.get(k);
                            String rep = "\\$\\{"+matchPattern.group(1)+"\\}";
                            exVal = exVal.replaceAll(rep, val);

                        }
                        String r = e.getName()+":"+exVal+" $";
                        res.add(r);
                    } else if(e.getExpressionType()!= null && e.getExpressionType().equals("DIRECT") && e.getExpression() != null){
                        String r = e.getName()+":"+e.getExpression();
                        res.add(r);
                    }
                }

                return String.join(":", res);
            }
        }

     class Expression {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("expressionType")
        @Expose
        private String expressionType;
        @SerializedName("expression")
        @Expose
        private String expression;
        @SerializedName("dependencies")
        @Expose
        private List<String> dependencies = null;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getExpressionType() {
            return expressionType;
        }

        public void setExpressionType(String expressionType) {
            this.expressionType = expressionType;
        }

        public String getExpression() {
            return expression;
        }

        public void setExpression(String expression) {
            this.expression = expression;
        }

        public List<String> getDependencies() {
            return dependencies;
        }

        public void setDependencies(List<String> dependencies) {
            this.dependencies = dependencies;
        }

    }


        static String s = "[\n" +
                " {\n" +
                "    \"groupName\"  :  \"Group1\",\n" +
                "    \"expressions\":   [    \n" +
                "\t    { \n" +
                "           \"name\" : \"a\",\n" +
                "           \"expressionType\" : \"DIRECT\",\n" +
                "           \"expression: \"10\",                   \n" +
                "           \"dependencies :[ ]       \n" +
                "        },{\n" +
                "           \"name\" : \"b\",\n" +
                "           \"expressionType\" : \"RS_EXPRESSION\",\n" +
                "           \"expression\" : \"${a} + 10\",         \n" +
                "           \"dependencies\" : [\"a\"]\n" +
                "        }, {\n" +
                "           \"name\" : \"c\",\n" +
                "           \"expressionType\" : \"DOLLAR_EXPRESSION\", \n" +
                "           \"expression\" : \"${a} +  10\",\n" +
                "           \"dependencies\" : [\"a\"]\n" +
                "        }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"groupName\"  :  \"Group2\",\n" +
                "    \"expressions\":   [    \n" +
                "\t{ \n" +
                "           \"name\" : \"a\",\n" +
                "           \"expressionType\" : \"DIRECT\",\n" +
                "           \"expression: \"20\",\n" +
                "           \"dependencies :[ ]\n" +
                "        }, {\n" +
                "           \"name\" : \"b\",\n" +
                "           \"expressionType\" : \"RS_EXPRESSION\",\n" +
                "           \"expression\" : \"${a} +  10\",\n" +
                "           \"dependencies\" : [\"a\"]\n" +
                "        }\n" +
                "    ]\n" +
                "  }]\n" ;
    /*+
                "  {\n" +
                "    \"groupName\"  :  \"Group3\",\n" +
                "    \"expressions\":  [] \n" +
                "  }\n" +
                "]\n";

     */


    }

