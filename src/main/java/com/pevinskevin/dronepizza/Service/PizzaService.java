package com.pevinskevin.dronepizza.Service;
import com.pevinskevin.dronepizza.Model.Pizza;
import com.pevinskevin.dronepizza.Reposittory.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public Pizza savePizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public Pizza getPizzaById(Long id) {
        return pizzaRepository.findById(id).orElse(null);
    }
}
