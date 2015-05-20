LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)
LOCAL_SRC_FILES := $(call all-subdir-java-files)
LOCAL_MODULE_TAGS := optional
LOCAL_MULTILIB := 32
#LOCAL_SDK_VERSION := 14
LOCAL_PROGUARD_ENABLED := disabled
LOCAL_PACKAGE_NAME := UsbSpeedSwitch

include $(BUILD_PACKAGE)

