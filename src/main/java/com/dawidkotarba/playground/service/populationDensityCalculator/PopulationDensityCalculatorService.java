package com.dawidkotarba.playground.service.populationDensityCalculator;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;

/**
 * Created by Dawid Kotarba on 19.12.2015.
 */

@Service
public class PopulationDensityCalculatorService {

    public float calculate(PopulationDensityCalculationInputData inputData) {
        Preconditions.checkArgument(inputData.getArea() > 0, "Area has to be a positive number");

        return inputData.getPopulation() / inputData.getArea();
    }
}
