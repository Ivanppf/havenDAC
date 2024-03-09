package com.ippf.havendac.view;

import com.ippf.havendac.entities.HavenEntity;

import java.util.List;

public interface Menu {

    public HavenEntity create();

    public List<HavenEntity> getAll();

    public void save();

}
