package nesneyonemlianaliz2;

public class Eyleyici implements IEyleyici {
	
	private int durum;

    public Eyleyici() {
    	durum=0;
    }

    @Override
    public void SogutucuyuAc() {
    	
    	System.out.println("SO�UTUCU A�ILIYOR...");
    	durum=1;

    }

    @Override
    public void SogutucuyuKapat() {
    	
        System.out.println("SO�UTUCU KAPATILIYOR...");
        durum=0;
    }
    
   public int getdurum()
   {
	   return durum;
   }
    
    
    
}
