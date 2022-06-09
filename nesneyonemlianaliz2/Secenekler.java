package nesneyonemlianaliz2;

public class Secenekler implements ISecenekler {
	 private IEkran ekran;
	    public Secenekler(IEkran ekran) {
	        this.ekran = ekran;
	    }

	    @Override
	    public  void AnaMenuyuGoster() {
	        ekran.mesajYazdir("-- Ana Men�ye Ho�geldiniz--");
	        ekran.mesajYazdir("1- So�utuyucu A�");
	        ekran.mesajYazdir("2- So�utucuyu Kapat");
	        ekran.mesajYazdir("3- S�cakl��� ��ren");
	        ekran.mesajYazdir("Hangi i�lemi yapmak istiyorsunuz ?");

	    }
}
