package com.ippf.havendac.view;

import com.ippf.havendac.entities.HavenEntity;

import java.util.List;

public interface Menu {

    HavenEntity create();

    List<HavenEntity> getAll();

    void save();

}
