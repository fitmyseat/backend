package com.fitmyseat.seat.service;

import com.fitmyseat.seat.entity.Sales;
import com.fitmyseat.seat.repository.SalesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SalesService {

    private final SalesRepository salesRepository;

    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    public Optional<Sales> getSaleById(Long id) {
        return salesRepository.findById(id);
    }

    public Sales createSale(Sales sale) {
        return salesRepository.save(sale);
    }

    public Sales updateSale(Long id, Sales saleDetails) {
        Optional<Sales> optionalSale = salesRepository.findById(id);
        if (optionalSale.isPresent()) {
            Sales sale = optionalSale.get();
            sale.setPartyName(saleDetails.getPartyName());
            sale.setVehicleName(saleDetails.getVehicleName());
            sale.setModel(saleDetails.getModel());
            sale.setColor(saleDetails.getColor());
            sale.setStitch(saleDetails.getStitch());
            sale.setQuantity(saleDetails.getQuantity());
            sale.setUnitPrice(saleDetails.getUnitPrice());
            sale.setTotalPrice(saleDetails.getTotalPrice());
            sale.setPaymentMode(saleDetails.getPaymentMode());
            sale.setMobileNumber(saleDetails.getMobileNumber());
            sale.setAddress(saleDetails.getAddress());
            sale.setRemarks(saleDetails.getRemarks());
            sale.setProductId(saleDetails.getProductId());
            return salesRepository.save(sale);
        }
        return null;
    }

    public boolean deleteSale(Long id) {
        if (salesRepository.existsById(id)) {
            salesRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Sales> getSalesByDateRange(LocalDate startDate, LocalDate endDate) {
        return salesRepository.findBySaleDateBetween(startDate, endDate);
    }
}
