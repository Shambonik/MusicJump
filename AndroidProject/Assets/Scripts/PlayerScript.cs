using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerScript : MonoBehaviour
{

    private float speed = 3.2f;
    private float jumpForce = 1000;
    private Rigidbody2D _rigidbody;
    private Vector3 _forwardMovement;
    private Vector3 _jump;
    private bool _jumping = false;
    private Vector3 _padding = new Vector3(0.5f, 0, 0);
    private float _jumpTime = 0;
    private CameraScript _camera;
    
    /// <summary>
    /// Метод Start, вызывается при запуске сцены
    /// </summary>
    void Start()
    {
        _rigidbody = transform.GetComponent<Rigidbody2D>();
        _forwardMovement = new Vector3(speed, 0, 0);
        _jump = new Vector3(0, jumpForce, 0);
        _camera = GameObject.FindObjectOfType<CameraScript>();
    }

    
    /// <summary>
    /// Метод Update, вызывается при каждом новом кадре
    /// </summary>
    void Update()
    {
        _rigidbody.velocity = _rigidbody.velocity * Vector2.up;
        transform.rotation = Quaternion.Euler(Vector3.zero);
        transform.Translate(_forwardMovement*Time.deltaTime);
        if (_jumping && Time.time - _jumpTime > 0.03f && isOnEarth())
        {
            _jumping = false;
        }
        Debug.Log(_jumping);
        if (!_jumping)
        {
            _camera.SetCameraY(transform.position.y);
        }
    }

    /// <summary>
    /// Метод isJumping
    /// </summary>
    /// <returns>Находится ли в прыжке игрок</returns>
    public bool isJumping()
    {
        return _jumping;
    }

    /// <summary>
    /// Метод isOnEarth, определяет, находится ли на земле игрок
    /// </summary>
    /// <returns>Находится ли на земле игрок</returns>
    private bool isOnEarth()
    {
        RaycastHit2D hitRight = Physics2D.Raycast(transform.position + _padding, Vector3.down);
        RaycastHit2D hitLeft = Physics2D.Raycast(transform.position - _padding, Vector3.down);
        float distance = 10;
        if (hitRight.collider != null)
        {
            distance = transform.position.y - hitRight.point.y;
        }
        if (hitLeft.collider != null && distance > 0.7f)
        {
            distance = transform.position.y - hitLeft.point.y;
        }
        if (distance < 0.7f)
        {
            return true;
        }
        return false;
    }

    /// <summary>
    /// Метод Jump, начинает прыжок игрока
    /// </summary>
    public void Jump()
    {
        if (!_jumping)
        {
            _rigidbody.velocity = _rigidbody.velocity * Vector2.right;
            _camera.SetCameraY(transform.position.y);
            _jumping = true;
            _jumpTime = Time.time;
            _rigidbody.AddForce(_jump);
        }
    }
}
