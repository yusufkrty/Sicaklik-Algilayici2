package nesneyonemlianaliz2;

import java.util.Scanner;

public class AgArayuzu implements IAgArayuz{
		//Dependency
		private IEkran ekran;
	    private IKisi kullanici;
	    private IVeritabani veriTabaniSurucusu;
	    private IMerkezi�slem anaIslem;
	    private ITusTakimi tustakimi;
	    
	    //Ag Arayuzunu olu�tugunda ekran, tus takimi, veritabani ve merkezi i�lem de olu�turur.
	    public AgArayuzu() {
	        this.ekran = new Ekran();
	        this.tustakimi=new TusTakimi();
	        this.veriTabaniSurucusu=new PostgresqlVeritabani();
	        this.anaIslem=new Merkezi�slem(ekran,this);
	    }

	    public void Basla()
	    {
	       
	        do {
	            ekran.mesajYazdir("--------------------------------");
	            ekran.mesajYazdir("- Ho�geldiniz -- \n\nL�tfen Giri� Yap�n�z");
	            ekran.mesajYazdir("Kullan�c� Ad�n�z� Giriniz :");
	            String kullaniciadi =tustakimi.stringVeriAl();
	            ekran.mesajYazdir("�ifrenizi Giriniz :");
	            String sifre = tustakimi.stringVeriAl();
	            
	            //FACTORY METHOD UYGULAMA
	            kullanici = KullaniciFactory.getKisi(kullaniciadi, sifre);
	            
	        }while (!KullaniciDogrula(kullanici));
	        
	        ekran.mesajYazdir(kullanici.getKullaniciAdi()+", HO� GELD�N�Z...");
	        IslemSecimi();
	        
	    }

	    @Override
	    public boolean KullaniciDogrula(IKisi kullanici) {
	        ekran.mesajYazdir("**Veritaban�na ba�lanma i�lemi ger�ekle�tiriliyor**");
	        Araclar.delay(500);
	        
	        if(!veriTabaniSurucusu.baglan())
	        {
	            ekran.mesajYazdir("Veritaban�na ba�lan�lma i�lemi ger�ekle�tirilmiyor. L�tfen tekrar deneyiniz.");
	            return false;
	        }
	        
	        if(!veriTabaniSurucusu.kullaniciKontrol(kullanici))
	        {
	            ekran.mesajYazdir("Kullan�c� ad� veya �ifreniz hatal�d�r. L�tfen tekrar giri� yap�n�z.");
	            return  false;
	        }
	        
	        else{
	        	ekran.mesajYazdir("Veritabanina ba�ar�l� bir �ekilde ba�lan�ld�.");
	            return true;
	        }
	    }


	    @Override
	    public void IslemSecimi() {
	    	
	      
	        Secenekler secenekler = new Secenekler(ekran);
	        
	        String devam;
	        do {
	            secenekler.AnaMenuyuGoster();
	            int islem = tustakimi.intVeriAl();
	            tustakimi.stringVeriAl();
	            
	            anaIslem.IslemiGerceklestir(islem);
	            ekran.mesajYazdir("��leme devam etmek istiyor musunuz ? (E/H)");
	            devam = tustakimi.stringVeriAl();
	            
	        } while ((devam.equalsIgnoreCase("E") && devam.equalsIgnoreCase("e")));
	        ekran.mesajYazdir("�yi g�nler dileriz.");
	    }

	   
}
