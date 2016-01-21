
public class Runner implements Runnable{

  public Runner(String runnerName){
    this.runnerName=runnerName;
  }
  private String runnerName; 
  private Integer i=0;
  
  @Override
  public void run() {
    while(true)
    {
      System.out.println(runnerName+":: "+i++);
    }
  }
  
  public static void main(String[] args) {
    for(int i=0;i<5;i++)
    {
      Thread run=new Thread(new Runner("run"+i));
      run.start();
    }

  }


}
