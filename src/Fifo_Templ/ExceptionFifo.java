package Fifo_Templ;



enum ErrCode { FIFO_OVERFLOW, FIFO_IS_EMPTY, OTHER_ERROR}


public class ExceptionFifo extends RuntimeException // Exception
{
    private ErrCode mErrCode;
    ExceptionFifo(ErrCode errCode){
        mErrCode=errCode;
    }
    public String getReason()
    {
        switch(mErrCode){
            case FIFO_OVERFLOW: return "\nFifo overflow!\n";
            case FIFO_IS_EMPTY: return "\nFifo is empty!\n";
            default: return"\nOther error!\n";
        }
    }
}