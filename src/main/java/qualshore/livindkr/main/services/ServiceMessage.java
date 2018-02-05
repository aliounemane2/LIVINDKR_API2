package qualshore.livindkr.main.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by User on 02/02/2018.
 */

@Service
public class ServiceMessage {

  HashMap<String, Object> result = new HashMap<>();

  public void SetMessage(String index, Object value){
    result.put(index, value);
  }

  public HashMap<String,Object> getMessage(){
    return result;
  }
}
