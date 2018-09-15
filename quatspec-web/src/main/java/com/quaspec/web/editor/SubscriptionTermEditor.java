package com.quaspec.web.editor;

import java.beans.PropertyEditorSupport;

import com.quaspec.persistence.enums.SubscriptionStatus;

public class SubscriptionTermEditor extends PropertyEditorSupport
{
  public void setAsText(String text)
    throws IllegalArgumentException
  {
    SubscriptionStatus sType = SubscriptionStatus.valueOf(text);

    setValue(sType);
  }
}