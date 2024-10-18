import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        RuleEngine engine = new RuleEngine();

        // Rule 1: (age > 30 AND department = 'Sales')
        String ruleString1 = "age > 30 AND department = 'Sales'";
        Node ast1 = engine.createRule(ruleString1);

        // Rule 2: (age < 25 AND department = 'Marketing')
        String ruleString2 = "age < 25 AND department = 'Marketing'";
        Node ast2 = engine.createRule(ruleString2);

        // Rule 3: (salary > 50000 OR experience > 5)
        String ruleString3 = "salary > 50000 OR experience > 5";
        Node ast3 = engine.createRule(ruleString3);

        // Combine rules: Rule1 OR Rule2 AND Rule3
        Node combinedAST = engine.combineRules(
            engine.combineRules(ast1, ast2, "OR"), ast3, "AND"
        );

        // Define a sample user data
        Map<String, Object> userData = new HashMap<>();
        userData.put("age", 35);
        userData.put("department", "Sales");
        userData.put("salary", 60000);
        userData.put("experience", 3);

        // Evaluate the combined rule against the user data
        boolean result = engine.evaluateRule(combinedAST, userData);
        System.out.println("Rule evaluation result: " + result); // Should print true or false based on rule evaluation
    }
}

