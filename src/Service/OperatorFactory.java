package Service;

import java.util.Map;
import Utils.Constants.*;
import Service.OperatorService.operator;

public class OperatorFactory {
	public static Map<String, operator> operatorList;
	public static operator createOperator(String operatorName, String operatorSymbol) {
		operator newOperator=null;

		if(operatorSymbol!=null || !operatorSymbol.isBlank())
		{
			if(operatorSymbol.compareTo(Character.toString(greaterThan))==0)
				newOperator = new greaterThanOperator(operatorName,operatorSymbol);
			//multiple operators as per the symbol
			
			operatorList.put(operatorSymbol, newOperator);
		}
		return newOperator;
	}

}
