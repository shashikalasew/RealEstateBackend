package com.example.RealEstateBackend.Sale;

import com.example.RealEstateBackend.Client.Client;
import com.example.RealEstateBackend.Client.ClientRepository;
import com.example.RealEstateBackend.Property.Property;
import com.example.RealEstateBackend.Property.PropertyRepository;
import com.example.RealEstateBackend.User.User;
import com.example.RealEstateBackend.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale getSaleById(int id) {
        return saleRepository.findById(id).orElse(null);
    }

    public Sale addSale(SaleDTO saleDTO) {
        Sale sale = new Sale();

        Property property = propertyRepository.findById(saleDTO.getPropertyId()).orElseThrow();
        sale.setProperty(property);

        Client client = clientRepository.findById(saleDTO.getClientId()).orElseThrow();
        sale.setClient(client);

        User user = userRepository.findById(saleDTO.getUserId()).orElseThrow();
        sale.setUser(user);

        sale.setFinalPrice(saleDTO.getFinalPrice());
        sale.setSellingDate(java.time.LocalDateTime.now());

        return saleRepository.save(sale);
    }

    public Sale updateSale(int id, SaleDTO saleDTO) {
        Sale sale = saleRepository.findById(id).orElse(null);
        if (sale != null) {

            Property property = propertyRepository.findById(saleDTO.getPropertyId()).orElseThrow();
            sale.setProperty(property);

            Client client = clientRepository.findById(saleDTO.getClientId()).orElseThrow();
            sale.setClient(client);

            User user = userRepository.findById(saleDTO.getUserId()).orElseThrow();
            sale.setUser(user);

            sale.setFinalPrice(saleDTO.getFinalPrice());
            sale.setSellingDate(java.time.LocalDateTime.now());

            return saleRepository.save(sale);
        }
        return null;
    }

    public void deleteSale(int id) {
        saleRepository.deleteById(id);
    }
}
