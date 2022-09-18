package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;

import com.project.exception.AddressNotFound;
import com.project.model.Address;
import com.project.repository.AddressDao;
import com.project.service.AddressService;
import com.project.service.AddressServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


    @SpringBootTest
    public class AddressServiceTest {
        @InjectMocks
        AddressService iAddressService = new AddressServiceImpl();

        @Mock
        AddressDao addressDao;

        @Test
        public void testViewAllAddress() {

            List<Address> address = new ArrayList<>();

            address.add(new Address());
            Mockito.when(addressDao.findAll()).thenReturn(address);
            assertEquals(1, iAddressService.viewAllAddress().size());

        }


    }


