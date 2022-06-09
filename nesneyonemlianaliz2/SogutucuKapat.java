package nesneyonemlianaliz2;

public class SogutucuKapat implements IIslem{
	
	 private IEyleyici eyleyici;
	    public SogutucuKapat(IEyleyici eyleyici) {
	        this.eyleyici = eyleyici;
	    }

	    @Override
	    public void IslemYap() {
	        eyleyici.SogutucuyuKapat();
	    }

	    @Override
	    public String toString() {
	        if(eyleyici.getdurum()==0)
	            return "So�utucu Zaten Kapal� Durumdad�r.";
	        else
	        return "So�utucu Kapat�ld�.";
	    }
}
