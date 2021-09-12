package com.its.RxVsRSocketServer.dataloader;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardMetaData implements Serializable {
    private CreditCard creditCard;
}
