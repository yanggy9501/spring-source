package com.readspring.service.cycledepency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yanggy
 */
@Component
public class Cycle1 {
    @Autowired
    private Cycle1 cycle2;
}
