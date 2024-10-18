import java.util.Map;

public class RuleEngine {

    // Parse rule from string into AST
    public Node createRule(String rule) {
        // This is a simplified parser for demonstration purposes.
        if (rule.contains("AND")) {
            String[] parts = rule.split("AND");
            return new Node("operator", createRule(parts[0].trim()), createRule(parts[1].trim()), "AND");
        } else if (rule.contains("OR")) {
            String[] parts = rule.split("OR");
            return new Node("operator", createRule(parts[0].trim()), createRule(parts[1].trim()), "OR");
        } else {
            return new Node("operand", null, null, rule);
        }
    }

    // Combine two ASTs using an operator
    public Node combineRules(Node rule1, Node rule2, String operator) {
        return new Node("operator", rule1, rule2, operator);
    }

    // Evaluate rule against the given data
    public boolean evaluateRule(Node node, Map<String, Object> data) {
        if (node.type.equals("operand")) {
            String[] condition = node.value.split(" ");
            String attribute = condition[0];
            String operator = condition[1];
            String value = condition[2];

            Object attributeValue = data.get(attribute);

            // Assuming integer comparisons for now
            int dataValue = (Integer) attributeValue;
            int ruleValue = Integer.parseInt(value);

            switch (operator) {
                case ">":
                    return dataValue > ruleValue;
                case "<":
                    return dataValue < ruleValue;
                case "=":
                    return dataValue == ruleValue;
                default:
                    throw new IllegalArgumentException("Unknown operator: " + operator);
            }
        } else {
            boolean leftResult = evaluateRule(node.left, data);
            boolean rightResult = evaluateRule(node.right, data);

            if (node.value.equals("AND")) {
                return leftResult && rightResult;
            } else if (node.value.equals("OR")) {
                return leftResult || rightResult;
            }
        }
        return false;
    }
}

