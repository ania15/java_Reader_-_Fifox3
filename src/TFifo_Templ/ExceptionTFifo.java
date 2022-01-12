package TFifo_Templ;



enum ErrCode { TFIFO_OVERFLOW, TFIFO_IS_EMPTY, OTHER_ERROR}


public class ExceptionTFifo extends RuntimeException // Exception
{
    private ErrCode mErrCode;
    ExceptionTFifo(ErrCode errCode){
        mErrCode=errCode;
    }
    public String getReason()
    {
        switch(mErrCode){
            case TFIFO_OVERFLOW: return "\nTFifo overflow!\n";
            case TFIFO_IS_EMPTY: return "\nTFifo is empty!\n";
            default: return"\nOther error!\n";
        }
    }
}