using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

/// <summary>
/// Класс, обрабатывающий нажатие на кнопку паузы.
/// </summary>
public class ButtonScript : MonoBehaviour
{
    private const string CLASS_NAME = "com.example.pause_plugin.Pause";
    private static AndroidJavaClass JavaClass;
    private bool buttonClicked = false;

    public void Start()
    {
        // JavaClass = new AndroidJavaClass(CLASS_NAME);
    }

    public bool buttonWasClicked()
    {
        bool res = buttonClicked;
        buttonClicked = false;
        return res;
    }

    
    /// <summary>
    /// Обработка нажатия
    /// </summary> 
    public void OnClick()
    {
        buttonClicked = true;
        Debug.Log("Clicked");
        // if(JavaClass!=null)
        // {
        //     FindObjectOfType<Text>().text = "here1";
        //     AndroidJavaClass ajc = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
        //     AndroidJavaObject ajo = ajc.GetStatic<AndroidJavaObject>("currentActivity");
        //     FindObjectOfType<Text>().text = "here2";
        //     JavaClass.CallStatic("Pause_Start", ajo);
        //     FindObjectOfType<Text>().text = "here3";
        // }
        // else
        // {
        //     FindObjectOfType<Text>().text = "here";
        // }
    }
}
