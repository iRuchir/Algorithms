package com.ruchir.ArraysAndStrings;

import java.util.LinkedList;

public class AnimalShelter {
	LinkedList<Animal> animalQueue = new LinkedList<Animal>();

	public void enqueue(Animal animal) {
		animalQueue.add(animal);
	}

	public Animal dequeueAny() {
		if (animalQueue.isEmpty()) {
			throw new IllegalStateException("No more animals available in the shelter.");
		}
		return animalQueue.poll();
	}

	public Dog dequeueDog() {

		if (animalQueue.isEmpty()) {
			throw new IllegalStateException("No more dogs available in the shelter.");
		}

		for (Animal animal : animalQueue) {
			if (animal instanceof Dog) {
				animalQueue.remove(animal);
				return (Dog) animal;
			}
		}
		throw new IllegalStateException("No more dogs available in the shelter.");
	}

	public Cat dequeueCat() {
		if (animalQueue.isEmpty()) {
			throw new IllegalStateException("No more cats available in the shelter.");
		}
		for (Animal animal : animalQueue) {
			if (animal instanceof Cat) {
				animalQueue.remove(animal);
				return (Cat) animal;
			}
		}
		throw new IllegalStateException("No more cats available in the shelter.");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(">>> ");
		for (Animal animal : animalQueue) {
			builder.append(animal.name + " -> ");
		}
		builder.append("|");
		return builder.toString();
	}
}
