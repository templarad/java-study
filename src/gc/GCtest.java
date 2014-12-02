package gc;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class GCtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<GCtestModel> oslist = new ArrayList<GCtestModel>();
		Thread t = new Thread();
		System.out.println("starting for");
		for(int i = 0 ; i < 1000 ; i++){
			oslist.add(new GCtestModel(String.valueOf(i)));
		}
		System.out.println("Made 1000 objects");
		GCtestModel os = new GCtestModel("This is the END Object.");
        WeakReference<GCtestModel> weakr = new WeakReference<GCtestModel>(os);
        SoftReference<GCtestModel> softr = new SoftReference<GCtestModel>(oslist.get(0));
        os = null;
        System.gc();

        try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
        if(weakr.get()!=null){
        	os = weakr.get();

        	os.getA();
        	System.out.println("Weak is alive: ¥n"+t.getName());
        }
        if(softr.get()!=null){
        	os = softr.get();
        	os.getA();
        	System.out.println("Soft is alive: ¥n"+t.getName());
        }
        
	}

}
