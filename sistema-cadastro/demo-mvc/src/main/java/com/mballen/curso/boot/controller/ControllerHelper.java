package com.mballen.curso.boot.controller;

import org.springframework.ui.Model;

public class ControllerHelper {

    public static void setEdit(Model model, boolean isEdit) {
        model.addAttribute("editMode", isEdit);
    }
}
