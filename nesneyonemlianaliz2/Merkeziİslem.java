package nesneyonemlianaliz2;

public class Merkezi�slem implements IMerkezi�slem {
	private final IEyleyici eyleyici;
    private final ISicaklikAlgilayici algilayici;
    private final IAgArayuz agArayuz;
    private final IEkran ekran;

    public Merkezi�slem(IEkran ekran,AgArayuzu agArayuz) {
        this.eyleyici = new Eyleyici();
        this.algilayici=new SicaklikAlgilayici(new Publisher());
         this.algilayici.AboneEkle(new Abone.AboneBuilder().setisim().setsoyisim().setyas().build());
        this.agArayuz = agArayuz;
        this.ekran = ekran;

    }



    @Override
    public void IslemiGerceklestir(int secim){
        IIslem islem;
        switch (secim)
        {
            case 1:
                islem = new SogutucuAc(eyleyici);
               
                ekran.mesajYazdir("Eyleyici �al��t�r�l�yor.");
                Araclar.delay(1000);
                islem.IslemYap();
               
                break;
            case 2:
                islem = new SogutucuKapat(eyleyici);
             
                ekran.mesajYazdir("Eyleyici �al��t�r�l�yor.");
                Araclar.delay(1000);
                islem.IslemYap();
                break;
            case 3:
                islem = new SicaklikAlgilayiciCalistir(algilayici);
              
                ekran.mesajYazdir("S�cakl�k Alg�lay�c� �al��t�r�l�yor..");
                Araclar.delay(1000);
                islem.IslemYap();
                ekran.mesajYazdir(islem.toString());
                break;
            default:
                ekran.mesajYazdir("L�tfen Ge�erli Se�im Yap�n�z.");
        }
    }
}
