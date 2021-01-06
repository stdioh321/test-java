package com.stdioh321.sboot.repositories.mysql;

import com.stdioh321.sboot.entities.mysql.City;
import com.stdioh321.sboot.repositories.IRepositoryExtender;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public interface TmpRepository extends IRepositoryExtender<City, String> {}
