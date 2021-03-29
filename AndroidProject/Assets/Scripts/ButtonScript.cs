using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ButtonScript : MonoBehaviour
{
    private const string CLASS_NAME = "com.example.pause_plugin.Pause";
    // private const string UnityActivity = "com.unity3d.player.UnityPlayerActivity";
    private static AndroidJavaClass JavaClass;

    public void Start()
    {
        JavaClass = new AndroidJavaClass(CLASS_NAME);
    }

    public void OnClick()
    {
        if(JavaClass!=null)
        {
            FindObjectOfType<Text>().text = "here1";
            AndroidJavaClass ajc = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
            AndroidJavaObject ajo = ajc.GetStatic<AndroidJavaObject>("currentActivity");
            FindObjectOfType<Text>().text = "here2";
            JavaClass.CallStatic("Pause_Start", ajo);
            FindObjectOfType<Text>().text = "here3";
        }
        else
        {
            FindObjectOfType<Text>().text = "here";
        }
    }
}
