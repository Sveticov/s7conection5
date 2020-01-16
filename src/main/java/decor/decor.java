package decor;

public class decor {
    public static void main(String[] args) {
        ImplTransleter caintransleter=new CainTranslete(new JapTrans());
        System.out.println(  caintransleter.transl());
    }
}
interface ImplTransleter
{
    String transl();
}

class JapTrans implements ImplTransleter {
    public String transl() {
        return "good japan";
    }
}

abstract class TranslDecor implements ImplTransleter {
    ImplTransleter jener;
    public TranslDecor(ImplTransleter jener){
        this.jener=jener;
    }
    abstract public String transl();
}

class CainTranslete extends TranslDecor{


    public CainTranslete(ImplTransleter jener) {
        super(jener);
    }

    @Override
    public String transl() {
        return jener.transl()+"  "+ "caina transleter";
    }
}
