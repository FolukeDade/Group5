package lottery;

public class GetHistory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean isSelect = DatabaseAdmin.sqlSelect(args[0]);
        if (isSelect == false) {
        	System.out.println("WARNING!!! - Something went wrong accessing the Database");
        }
	}

}