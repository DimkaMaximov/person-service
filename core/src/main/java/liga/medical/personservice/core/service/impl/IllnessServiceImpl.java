package liga.medical.personservice.core.service.impl;

import liga.medical.personservice.core.model.IllnessEntity;
import liga.medical.personservice.core.repository.IllnessRepository;
import liga.medical.personservice.core.service.IllnessService;
import liga.medical.personservice.dto.IllnessDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IllnessServiceImpl implements IllnessService {

    @Autowired
    IllnessRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<IllnessDto> findAll() {
        List<IllnessEntity> illnessList = repository.findAll();
        return illnessList.stream()
                .map(el -> modelMapper.map(el, IllnessDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public IllnessDto findById(Long id) {
        IllnessEntity illness = repository.findById(id);
        return modelMapper.map(illness, IllnessDto.class);
    }

    @Override
    public void insertAll(List<IllnessDto> illnessDtoList) {
        List<IllnessEntity> illnessList = illnessDtoList.stream()
                .map(el -> modelMapper.map(el, IllnessEntity.class))
                .collect(Collectors.toList());
        repository.insertAll(illnessList);
    }

    @Override
    public void insert(IllnessDto illnessDto) {
        IllnessEntity illness = modelMapper.map(illnessDto, IllnessEntity.class);
        if (illness.getId() == null) repository.insert(illness);
        else repository.updateById(illness);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}