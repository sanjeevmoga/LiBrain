package com.greenkey.librain;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Alexander on 09.02.2017.
 */

public class ItemGenerator {

    private static Random random = new Random();

    public static ResourceType[] createItems(Rule[] rules, int size) {
        ResourceType[] result = new ResourceType[size];
        Arrays.fill(result, ResourceType.NONE);

        int rulesCount = rules.length;
        for (int i = 0; i < rulesCount; i++) {
            int itemsCount = rules[i].getItemsCount();
            ResourceType itemsType = rules[i].getResourceType();

            int index;
            for (int j = 0; j < itemsCount; j++) {
                do {
                    index = random.nextInt(size);
                } while (result[index] != ResourceType.NONE);

                result[index] = itemsType;
            }
        }
        return result;
    }
}