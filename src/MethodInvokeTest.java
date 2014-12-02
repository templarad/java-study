import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class MethodInvokeTest {
	public static void test(){
		PeoModel people = new PeoModel();
		people.show();
		
		try {
			setFieldValueByName(people, "age", 18);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		people.show();
	}
	
	/** 
     * オブジェクトのフィールド値を取得する 
     * @param object    取得する対象となるオブジェクト     
     * @param fieldName フィールド名 
     *  
     */  
    public static Object getFieldValueByName(   
            Object object, String fieldName)   
    throws SecurityException, NoSuchMethodException,   
    IllegalArgumentException, IllegalAccessException, InvocationTargetException {  
          
        if (object == null)  
            return null;  
          
        Class cls = object.getClass();  
  
        //フィールドのgetメソッド名を取得  
        char firstChar = fieldName.charAt(0);  
        char uFirstChar = Character.toUpperCase(firstChar);  
        String getMethod = "get"  
                + fieldName.replaceFirst(String.valueOf(firstChar),  
                        String.valueOf(uFirstChar));  
          
        //getメソッドを取得  
        Method method = cls.getMethod(getMethod, null);  
        //getメソッドを呼び出し、戻り値はフィールドの値になります  
        Object objValue = method.invoke(object, null);  
          
        return objValue;  
    }  
      
    /** 
     * オブジェクトのフィールド値を設定する 
     * @param object    対象となるオブジェクト     
     * @param fieldName フィールド名 
     *  
     */  
    public static void setFieldValueByName(  
            Object object,  
            String fieldName,   
            Object fieldValue)   
    throws SecurityException, NoSuchFieldException, IllegalArgumentException,   
    IllegalAccessException, InvocationTargetException, NoSuchMethodException {  
                  
        if (object == null) {  
            return;  
        }  
          
        Class cls = object.getClass();  //オブジェクトのClass取得  
        Field field = cls.getDeclaredField(fieldName);  //文字列（フィールド名）からFieldオブジェクト取得  
        field.setAccessible(true);
        field.setInt(object, (Integer)fieldValue);
        Class fieldType = field.getType();  //フィールドの型取得  
        Class [] argTypes = {fieldType};  
        Object[] argValues = {fieldValue};  
          
        setFieldValueByName(cls, object, fieldName, argTypes, argValues);  
    }  
      
    public static void setFieldValueByName(Class cls,   
            Object object,  
            String fieldName,   
            Class [] argTypes,  
            Object [] argValues)   
    throws SecurityException, NoSuchFieldException, IllegalArgumentException,   
    IllegalAccessException, InvocationTargetException, NoSuchMethodException {  
        if (object == null)  
            return;  
  
        //setメソッド名  
        char firstChar = fieldName.charAt(0);  
        char uFirstChar = Character.toUpperCase(firstChar);  
        String setterMethod = "set"  
                + fieldName.replaceFirst(String.valueOf(firstChar),  
                        String.valueOf(uFirstChar));  
          
        //setメソッド  
        Method method = cls.getMethod(setterMethod, argTypes);  
        //setメソッド実行（オブジェクト、パラメータ）  
        method.invoke(object, argValues);  
    }  

}
