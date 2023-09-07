package com.tcj.wealth.msdashboardaggregator.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Amir
 */

@Getter
@AllArgsConstructor
public enum ErrorCode {
    CODE_01("DATA NOT FOUND"),
    CODE_02("DUPLICATE DATA"),
    CODE_03("SUCCESSFULLY CREATE NEW DATA"),
    CODE_04("SUCCESSFULLY DELETE NEW DATA"),
    CODE_05("SUCCESSFULLY RETRIEVE DATA"),
    CODE_06("SUCCESSFULLY UPDATE DATA"),
    CODE_07("UNSUCCESSFULLY CREATE NEW DATA"),
    CODE_08("UNSUCCESSFULLY DELETE NEW DATA"),
    CODE_09("UNSUCCESSFULLY RETRIEVE DATA"),
    CODE_10("UNSUCCESSFULLY UPDATE DATA"),
    CODE_11("DATA ERROR");

    private String name;

}
