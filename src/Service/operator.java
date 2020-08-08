/**
 * 
 */
package Service;

import java.util.List;

/**
 * @author aditya
 *
 */
public interface operator {
	
	public Object evaluate(List<Object> operands);
	public int precendenceAndAssociativity();
	public int getNumberOfOperands();
	public String getOperator();
}
