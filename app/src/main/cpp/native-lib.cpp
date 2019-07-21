#include <jni.h>
#include <string>



extern "C" JNIEXPORT jstring JNICALL
Java_com_sample_nativecodesample_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    int iSecret=rand()%10;
    std::string hello = "Hello from C++"+std::to_string(iSecret);
    return env->NewStringUTF(hello.c_str());
}
