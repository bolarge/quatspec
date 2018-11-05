package com.quatspec.web.editor;

import java.beans.PropertyEditorSupport;

import com.quatspec.api.enums.SubscriptionStatus;

public class SubscriptionTermEditor extends PropertyEditorSupport
{
  public void setAsText(String text)
    throws IllegalArgumentException
  {
    SubscriptionStatus sType = SubscriptionStatus.valueOf(text);

    setValue(sType);
  }
}