package nesneyonemlianaliz2;

public class SicaklikAlgilayici implements ISicaklikAlgilayici{
	
	     private int sicaklik;
	     private ISUbject publisher;
	    public SicaklikAlgilayici(ISUbject publisher) {
	    	this.publisher=publisher;
	    }

	    public int getSicaklik() {
	        return sicaklik;
	    }

	    @Override
	    public void SicaklikOlc() {
	        sicaklik = (int)(Math.random()*15+50);
	        if(sicaklik>50)
	        {
	        	
	        	 publisher.notify("S�cakl�k 50 derecenin �zerine ��kt�! L�tfen so�utucuyu a��n�z!");
	        }
	    }
	    
	    @Override
	    public void AboneEkle(Observer abone) {
	        publisher.attach(abone);
	    }
	    
}
