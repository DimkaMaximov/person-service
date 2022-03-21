package liga.medical.personservice.core.service.impl;

import liga.medical.personservice.core.model.MedicalCardEntity;
import liga.medical.personservice.core.repository.MedicalCardRepository;
import liga.medical.personservice.core.service.MedicalCardService;
import liga.medical.personservice.dto.MedicalCardDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalCardServiceImpl implements MedicalCardService {

    @Autowired
    MedicalCardRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<MedicalCardDto> findAll() {
        List<MedicalCardEntity> medicalCardList = repository.findByIds();
        return medicalCardList.stream()
                .map(el -> modelMapper.map(el, MedicalCardDto.class))
                .collect(Collectors.toList());
    }

    public MedicalCardDto findById(Long id) {
        MedicalCardEntity medicalCard = repository.findById(id);
        return modelMapper.map(medicalCard, MedicalCardDto.class);
    }

    public void insertAll(List<MedicalCardDto> medicalCard) {
        List<MedicalCardEntity> cardEntityList = medicalCard.stream()
                .map(el -> modelMapper.map(el, MedicalCardEntity.class))
                .collect(Collectors.toList());
        repository.insertAll(cardEntityList);
    }

    public void insert(MedicalCardDto medicalCard) {
        MedicalCardEntity cardEntity = modelMapper.map(medicalCard, MedicalCardEntity.class);
        repository.insert(cardEntity);
    }

    @Override
    public void deleteById(Long id) {

    }
}
