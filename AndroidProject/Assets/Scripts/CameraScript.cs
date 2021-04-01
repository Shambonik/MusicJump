using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/// <summary>
/// Класс, управляющий перемещением камеры.
/// </summary>
public class CameraScript : MonoBehaviour
{
    private PlayerScript _player;
    private float _cameraY = 0;
    
    /// <summary>
    /// Метод Start, вызывается при запуске сцены
    /// </summary>
    void Start()
    {
        _player = GameObject.FindGameObjectWithTag("Player").GetComponent<PlayerScript>();
    }

    /// <summary>
    /// Метод SetPlayerY, назначает y-координату, на которой должна держаться камера
    /// </summary>
    /// <param name="cameraY">Координата Y для камеры</param>
    public void SetCameraY(float cameraY)
    {
        _cameraY = cameraY;
    }

    /// <summary>
    /// Метод Update, вызывается при каждом новом кадре
    /// </summary>
    void Update()
    {
        transform.position = Vector3.Lerp(transform.position,new Vector3(_player.transform.position.x + 5, _cameraY, transform.position.z), 0.02f);
    }
}
