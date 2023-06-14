package com.bracit.vouchermanager.common.enums;

public enum EsbFlag {
    SYNC(1,"Voucher will be directly posted from ESB to MF"),
    ASYNC_FLAG(2,"Voucher will be queued in ESB until" +
            "Receiving flush instruction. After receiving flush instruction " +
            "it will be posted from ESB to MF");

    private int flag;
    private String flagDetails;

    EsbFlag(int flag, String flagDetails){
        this.flag =flag;
        this.flagDetails = flagDetails;
    }
}
