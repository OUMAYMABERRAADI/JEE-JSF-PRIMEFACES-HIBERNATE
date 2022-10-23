package FPL.SIDSD.Service;

import java.util.List;


public interface IService <T>{
	
	List<T> getSorted();
	String getFKey(int i);

}
