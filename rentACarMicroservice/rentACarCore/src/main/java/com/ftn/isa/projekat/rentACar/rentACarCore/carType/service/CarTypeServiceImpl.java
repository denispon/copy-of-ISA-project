package com.ftn.isa.projekat.rentACar.rentACarCore.carType.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarTypeDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.carType.model.CarType;
import com.ftn.isa.projekat.rentACar.rentACarCore.carType.repository.CarTypeRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOCarTypeConverter;

@Service
public class CarTypeServiceImpl implements ICarTypeService {

	@Autowired
	CarTypeRepository carTypeRepository;
	
	@Autowired
	DTOCarTypeConverter carTypeConverter;

	@Transactional(readOnly = true, isolation=Isolation.READ_COMMITTED)
	@Override
	public CarTypeDTO findOneById(Long id) {
		Optional <CarType> carType = carTypeRepository.findById(id);
		
		
		if (carType.isPresent()) {
			
			return carTypeConverter.convertToDTO(carType.get());
		
		}
		else {
			
			return new CarTypeDTO();
			
		}
	}

	@Transactional(readOnly= true, isolation=Isolation.READ_COMMITTED)
	@Override
	public List<CarTypeDTO> findAll() {
		Optional< List<CarType> > list = Optional.of(carTypeRepository.findAll());
		ArrayList< CarTypeDTO > CarTypesDTO = new ArrayList< CarTypeDTO >();
		
		if ( list.isPresent() ) {
			
			for ( CarType carType : list.get()) {
				
				CarTypesDTO.add(carTypeConverter.convertToDTO(carType));
				
			}
			
			return CarTypesDTO;
			
		}
		
		return Collections.emptyList();
	}

	@Transactional(readOnly = false, isolation=Isolation.READ_COMMITTED)
	@Override
	public CarTypeDTO save(CarTypeDTO carTypeToSave) {
		
		carTypeToSave.setId(-1l);
		
		CarType carType =carTypeRepository.save(carTypeConverter.convertFromDTO(carTypeToSave));
		
		carTypeToSave.setId(carType.getId());
		
		return carTypeToSave;
	}

	@Transactional(readOnly = false, isolation=Isolation.REPEATABLE_READ)	
	@Override
	public CarTypeDTO deleteById(Long id) {
		
		Optional<CarType> carTypeToDelete = carTypeRepository.findById(id);
		
		if( carTypeToDelete.isPresent() ) {
		
			carTypeRepository.deleteById(id);
			return carTypeConverter.convertToDTO(carTypeToDelete.get());
		
		}
		
		return new CarTypeDTO();
		
	}

	@Transactional(readOnly = false, isolation=Isolation.REPEATABLE_READ)	
	@Override
	public CarTypeDTO changeCarType(Long id, CarTypeDTO carType) {
		
		Optional<CarType> carTypeForChange = carTypeRepository.findById(id);
		
		if (carTypeForChange.isPresent() && carType!=null) {
			
			carTypeForChange.get().setBrand(carType.getBrand());
			carTypeForChange.get().setCarType(carType.getCarType());
			carTypeForChange.get().setModel(carType.getModel());
			carTypeForChange.get().setModelYear(carType.getModelYear());
			carTypeForChange.get().setNumberOfSeats(carType.getNumberOfSeats());
			
			carTypeRepository.save(carTypeForChange.get());
			
			carType.setId(carTypeForChange.get().getId());
			
			return carType;
		}
		return new CarTypeDTO();
	}
	
	
}
