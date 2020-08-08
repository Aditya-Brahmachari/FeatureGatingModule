package Service;

import java.util.*;

import Service.OperatorService.operator;


public abstract class Feature {

	private static String InfixTopostFix(String conditionalStatement)
	{
		StringBuilder res = new StringBuilder();
		/*converting the conditional Statement to 
		 * postfix condition
		 *  */
		return res.toString();
	}

	boolean isAllowed(String conditionalStatement, String FeatureName, 
			Map<String,Object> userDetails)
	{
		boolean operation = false;
		String postFixConditionalStatement = InfixTopostFix(conditionalStatement);
		Stack<Object> stack =  new Stack<>();
		for(char c:postFixConditionalStatement.toCharArray())
		{
			//operator factory keeps record of all the operators created.
			if(OperatorFactory.operatorList.containsKey(Character.toString(c)))
			{
				
				if(userDetails.containsKey(Character.toString(c)))
				{
					stack.push(userDetails.get(Character.toString(c)));
				}

				else
				{
					stack.push(c);
				}
			}
			else
			{
				operator currentOperator = OperatorFactory.operatorList.get(Character.toString(c));
				int operandsExtracted = currentOperator.getNumberOfOperands();
				List<Object> currOperands = new ArrayList<>();
				while(operandsExtracted > 0 )
				{
					if(stack.isEmpty())
						return false;
					currOperands.add(stack.peek());
					stack.pop();
					operandsExtracted--;
				}
				stack.push(currentOperator.evaluate(currOperands));
				
			}
		}
        

		return stack.size()==1?stack.peek().equals(true):false;
	}

}
