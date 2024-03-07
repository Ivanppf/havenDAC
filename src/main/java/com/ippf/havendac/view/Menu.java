package com.ippf.havendac.view;

import com.ippf.havendac.entities.HavenEntity;

import java.util.List;

public interface Menu<T extends HavenEntity> {

    public T create();

    public List<T> getAll();

    public void save();

}
