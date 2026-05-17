package org.example.observerPattern;

public interface FitnessDataSubject {
    void registerObserver(FitnessDataObserver observer);

    void removeObserver(FitnessDataObserver observer);

    void notifyObservers();
}
